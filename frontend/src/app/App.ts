import axios from 'axios';
import Vue from 'vue';

export default Vue.extend({
    data() {

        return {

            notes: 'Fetching data, or something is wrong',
        }
    },

    methods: {

        getNote() {

            axios.get("http://localhost:8080/Ryanet/api/v1/note/list").then( (response) => {

                this.notes = response.data;
            });
        },

        getPathToSpecificNote(id: String) {

            return "http://localhost:8080/Ryanet/api/v1/note/" + id;
        }
    },
    
    created() {
        this.getNote();
    }
});