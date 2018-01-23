import vue from 'vue';
import App from './App.vue';
import upload from './components/upload/upload.vue';

new vue({
    el: '#app',
    components: {
        App,
        upload,
    },
    // render: h => h( App)
    template: '<App/>',
});
