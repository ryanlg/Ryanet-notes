import { RLCellNote } from '@notes/model';

export default {

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

};
