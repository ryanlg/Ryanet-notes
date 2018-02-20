import axios from 'axios';

import config from '@config';

import { NoteCell } from '../../cells';
import { RLCellNote } from 'src/js/notes/model';
import Upload from './components/upload';

export default {

    name: 'master',

    components: {
        Upload,
        'note-cell': NoteCell,
    },

    data() {

        return {

            notes: [],
            showUpload: false,
        };
    },

    methods: {

        getNotes() {
            axios.get(config.backend('/api/v1/note/list')).then((res) => {

                this.notes = res.data;
            });
        },

        toCellNote(oriNote: any) {
  
            return new RLCellNote(oriNote.id, oriNote.name, oriNote.modified_date, '');
        },

        toggleUpload() {

            this.showUpload = !this.showUpload;
        },
    },

    created() {

        this.getNotes();
    },
};
