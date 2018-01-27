import Vue from 'vue';

import { RLCellNote } from 'src/model/RLCellNote';

export default Vue.component('note-cell', {

    props: {

        note: RLCellNote,

    },

    data() {

        return {

            noteName: this.note.name,
        };
    },

    methods: {
    },

});
