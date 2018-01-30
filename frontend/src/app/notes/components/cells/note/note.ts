import { RLCellNote } from 'src/model';

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
