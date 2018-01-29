import Vue from 'vue';
import axios from 'axios';
import { master } from 'src/sides/';

import Config from '@config';

import 'assets/style/normalize.css'; // Normalize.css
import 'assets/style/global.scss'; // Global styles

export default Vue.extend({
    name: 'App',
    components: {
        master,
    },
});
