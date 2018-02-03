import RLCellNote from '@notes/model/RLCellNote';
import RLNote from '@notes/model/RLNote';
import NoteService from 'src/util/NoteService';

export default {

    name: 'viewer',

    props: {

        id: {
            required: true,
        },
    },

    data() {

        return {
            
            note: null,
        };
    },

    computed: {

        noteHtml() {

            return this.note.content;
        },
    },

    created() {

        NoteService.getNoteByID(this.id).then((res) => {

            this.note = res;
        });
    },
};
