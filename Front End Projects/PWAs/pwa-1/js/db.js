// offline data
db.enablePersistence()
    .catch(err => {
        if(err.code == 'failed-precondition') {
            console.log('persistence failed');
        } else if(err.code == 'unimplemented') {
            console.log('persistence is not available');
        }
    })

// real-time listener
db.collection('recipies').onSnapshot(snapshot => {
    // console.log(snapshot.docChanges());
    snapshot.docChanges().forEach(change => {
        // console.log(change, change.doc.data(), change.doc.id);
        if(change.type === 'added') {
            // add data to dom
            renderRecipie(change.doc.data(), change.doc.id)
        }
        else if(change.type == 'removed') {
            // removed data from dom
            removeRecipie(change.doc.id);
        }
    })
})

// add new recipe
const form = document.querySelector('form');
form.addEventListener('submit', ev => {
    ev.preventDefault();
    const recipe = {
        title: form.title.value,
        ingredients: form.ingredients.value
    }
    db.collection('recipies').add(recipe)
        .catch(err => {
            console.log(err);
        })

    form.title.value = "";
    form.ingredients.value = "";
});

// delete a recipe
const recipeContainer = document.querySelector('.recipes');
recipeContainer.addEventListener('click', ev => {
    if(ev.srcElement.nodeName === 'I') {
        const id = ev.srcElement.attributes['data-id'].value;
        console.log(id);
        db.collection('recipies').doc(id).delete();
    }
})