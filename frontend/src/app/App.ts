import axios from 'axios';
import Vue from 'vue';

import Config from '@config'

export default Vue.extend({
    data() {

        return {

            notes: 'Fetching data, or something is wrong',
        }
    },

    methods: {

        getNote() {

            axios.get(Config.backend("/api/v1/note/list")).then( (response) => {

                this.notes = response.data;
            });
        },

        getPathToSpecificNote(id: String) {

            return Config.backend("/api/v1/note/") + id;
        }
    },
    
    created() {
        this.getNote();
    }
});