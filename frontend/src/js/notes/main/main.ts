import Vue from 'vue';

import { master, viewer } from '@notes/components/sides';

export default  {

    name: 'notes',

    components: {
        master,
        viewer,
    },

    computed: {

        id() {
       
            if (this.$router.params.id) {
                
                return this.$router.params.id;
            }

            return null;
        },
    },

};
