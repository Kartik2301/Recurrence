const staticCacheName = 'site-static-v7';
const dynamicCacheName = 'site-dynamic-v7';
// new 
const assets = [
    '/',
    '/index.html',
    '/js/ui.js',
    '/js/app.js',
    '/js/materialize.min.js',
    '/css/styles.css',
    '/css/materialize.min.css',
    '/img/dish.png',
    'https://fonts.googleapis.com/icon?family=Material+Icons',
    'https://fonts.gstatic.com/s/materialicons/v47/flUhRq6tzZclQEJ-Vdg-IuiaDsNcIhQ8tQ.woff2',
    '/pages/fallback.html',
]

// cache size limit
const limitCacheSize = (name, size) => {
    caches.open(name).then(cache => {
        cache.keys().then(keys => {
            if(keys.length > size) {
                cache.delete(keys[0]).then(limitCacheSize(name, size));
            }
        })
    })
}

// install event

self.addEventListener('install', ev => {
    ev.waitUntil(
        caches.open(staticCacheName).then(cache => {
        console.log('caching shell assets');
        cache.addAll(assets)
      })
    )
})

// activate event

self.addEventListener('activate', ev => {
    // console.log('service worker activated');
    ev.waitUntil(
        caches.keys().then(keys => {
            // console.log(keys);
            return Promise.all(keys
                .filter(key => key !== staticCacheName && key !== dynamicCacheName)
                .map(key => caches.delete(key)))
        })
    )
})

// fetch events

self.addEventListener('fetch', ev => {
    if(ev.request.url.indexOf('firestore.google.apis.com') === -1) {
        ev.respondWith(
            caches.match(ev.request).then(cacheRes => {
                return cacheRes || fetch(ev.request).then(fetchRes => {
                    return caches.open(dynamicCacheName).then(cache => {
                        cache.put(ev.request.url, fetchRes.clone());
                        limitCacheSize(dynamicCacheName, 15);
                        return fetchRes;
                    })
                })
            }).catch(() => {
                if(ev.request.url.indexOf('.html') > -1) {
                    return caches.match('/pages/fallback.html');
                }
            })
        );
    }
});