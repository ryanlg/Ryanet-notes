import vue from 'vue';
import App from './App.vue';
import router from './router';
import upload from './components/upload/upload.vue';

new vue({
    router,
    el: '#app',
    components: {
        App,
        upload,
    },
    // render: h => h( App)
    template: '<App/>',
});
