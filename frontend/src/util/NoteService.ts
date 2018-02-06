import axios from 'axios';
import config from '@config';
import RLNote from '@notes/model/RLNote';

export default {

    getNoteByID(id: string): Promise<RLNote> {

        return new Promise((resolve, rejected) => {

            axios.get(config.noteApi('/' + id)).then((res) => {

                const noteJson = res.data;

                console.log(noteJson);
                
                // TODO: complete this logic
                const newNote = new RLNote;
                newNote.id = id;
                newNote.name = noteJson.name;
                newNote.content = noteJson.html; // TODO: content should be html not raw
                // TODO: extract incoming note to model too

                resolve(newNote);

            }).catch(rejected);
        });
    },
};
