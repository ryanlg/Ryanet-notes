import Vue from 'vue';

import { RLCellNote } from 'src/model';

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
