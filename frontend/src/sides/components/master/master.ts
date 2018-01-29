import Vue from 'vue';
import axios from 'axios';

import config from '@config';

import { NoteCell } from 'src/cells';
import { RLCellNote } from 'src/model';

export default Vue.component('master', {

    data() {

        return {

            notes: [],
        };
    },

    methods: {

        getNotes() {
            axios.get(config.backend('/api/v1/note/list')).then((res) => {

                this.notes = res.data;
            });
        },

        toCellNote(oriNote: any) {

            const cellNote = new RLCellNote();
            cellNote.id = oriNote.id;
            cellNote.name = oriNote.name;
            cellNote.modifiedTime = oriNote.modifiedTime;

            return cellNote;
        },
    },

    created() {

        this.getNotes();
    },
});
