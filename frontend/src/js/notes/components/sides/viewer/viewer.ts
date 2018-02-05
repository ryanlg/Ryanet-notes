import RLCellNote from '@notes/model/RLCellNote';
import RLNote from '@notes/model/RLNote';
import NoteService from 'src/util/NoteService';

export default {

    props: {

        id: {
            required: true,
        },
    },

    data() {

        return {
            
            note: null,
            noteHtml: '',
        };
    },

    created() {

        console.log('created');
        NoteService.getNoteByID(this.id).then((res) => {

            console.log(res);
            
            this.noteHtml = res;
        });
    },
};
