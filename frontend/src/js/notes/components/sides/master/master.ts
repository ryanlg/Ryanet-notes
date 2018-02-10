import axios from 'axios';

import config from '@config';

import { NoteCell } from '../../cells';
import { RLCellNote } from 'src/js/notes/model';

export default {

    name: 'master',

    components: {
        'note-cell': NoteCell,
    },

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
  
            return new RLCellNote(oriNote.id, oriNote.name, oriNote.modifiedTime, '');
        },
    },

    created() {

        this.getNotes();
    },
};
