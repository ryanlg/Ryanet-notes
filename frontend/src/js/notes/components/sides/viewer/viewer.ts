import RLCellNote from '@notes/model/RLCellNote';
import RLNote from '@notes/model/RLNote';
import NoteService from 'src/util/NoteService';

export default {
    props: {
        id: {},
    },

    data() {
        return {
            note: null,
            noteHtml: '',
        };
    },

    watch: {
        id() {
            
            if (typeof this.id !== 'undefined') {

                NoteService.getNoteByID(this.id).then((res) => {
                
                    this.noteHtml = res.html;
                });
            }
        },
    },
};
