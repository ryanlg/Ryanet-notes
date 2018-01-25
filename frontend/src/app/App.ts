import Vue from 'vue';
import axios from 'axios';
import master from 'src/components/sides/master';

import Config from '@config';

export default Vue.extend({
    name: 'App',
    components: {
        master
    },
});
