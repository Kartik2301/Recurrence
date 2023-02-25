
// Service Worker
importScripts('https://www.gstatic.com/firebasejs/8.10.1/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/8.10.1/firebase-messaging.js');

const firebaseConfig = {
    apiKey: "AIzaSyBWiyH8DQXWWwwOgXSe1UMxD7I2YKFPsIU",
    authDomain: "pwa-project-a0bd7.firebaseapp.com",
    projectId: "pwa-project-a0bd7",
    storageBucket: "pwa-project-a0bd7.appspot.com",
    messagingSenderId: "379310423780",
    appId: "1:379310423780:web:6bf4bf1908f64b508136f1",
    measurementId: "G-KEHQSF1SD0"
};

// // Initialize Firebase
const app = firebase.initializeApp(firebaseConfig);

// Initialize Firebase Cloud Messaging and get a reference to the service
const messaging = firebase.messaging()

messaging.onBackgroundMessage(payload => {
    console.log('[firebase-messaging-sw.js] Received background message ', payload);
    // Customize notification here
    const notificationTitle = 'Background Message Title';
    const notificationOptions = {
      body: 'Background Message body.',
      icon: '/thumb.png'
    };
  
    self.registration.showNotification(notificationTitle,
      notificationOptions);
  });