import Vue from 'vue';
import App from './App.vue';
import Upload from './components/uplaod/upload.vue'

new Vue ({
    el: '#app',
    
    components: {
        App,
        Upload
    },
    // render: h => h( App)
    template: '<App/>'
});