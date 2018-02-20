import { RLCellNote } from '@notes/model';

import config from '@config';

export default {

    props: {

        note: RLCellNote,

    },

    data() {

        return {

            noteName: this.note.name,
            noteModifiedTime: this.note.modifiedTime,
        };
    },

    methods: {

        getURL() {

            return config.noteBase('/' + this.note.id);
        },
    },

};
