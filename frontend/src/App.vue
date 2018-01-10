<template>
<div id="app">
    <p>{{ note }}</p>
</div>
</template>

<script lang="ts">
import axios from 'axios';
import Vue from 'vue';

export default Vue.extend({
    name: 'app',
    
    data: () => {
        return {note: 'does this shit work at all'}
    },
    methods: {
        getNote: () => {
            axios.get("localhost:8080/api/note/list").then( (response) => {
                return response;
            });
        }
    }
});
</script>
