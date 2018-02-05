import Vue from 'vue';

import { master, viewer } from '@notes/components/sides';

export default  {

    components: {
        master,
        viewer,
    },

    computed: {
        
        

        id() {
       
            if (typeof (this.$router.params.id) !== undefined) {
                
                return this.$router.params.id;
            }

            return null;
        },
    },

};
