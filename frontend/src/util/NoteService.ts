import axios from 'axios';
import config from '@config';
import RLNote from '@notes/model/RLNote';

export default {

    getNoteByID(id: string): Promise<RLNote> {

        return new Promise((resolve, rejected) => {

            axios.get(config.noteApi('/' + id)).then((res) => {

                const noteJson = res.data;

                // TODO: complete this logic
                const newNote = new RLNote;
                newNote.id = id;
                newNote.name = noteJson.name;
                newNote.content = noteJson.content;

                resolve(newNote);

            }).catch(rejected);
        });
    },
};
