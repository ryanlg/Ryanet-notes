import axios from "axios";

export default {
    name: 'app',

    methods: {
        getNote: () => {
            axios.get("localhost:8080/api/note/list").then( (response) => {
                return response;
            });
        }
    }
};