import axios from 'axios';
import Vue from 'vue';

export default Vue.extend({
    data: () => {
        return {
            note: 'Fetching data, or something is wrong' 
        }
    },

    methods: {

        getNote() {

            axios.get("http://localhost:8080/Ryanet/api/v1/note/list").then( (response) => {
                this.note = response.data;
            });
        }
    },
    
    created() {
        this.getNote();
    }
});