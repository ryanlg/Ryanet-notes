import axios from 'axios';
import config from '@config';
import RLNote from '@notes/model/RLNote';
import RLJson from './RLJson';

export default {

    backendJsonToRLNote(oriNote: any): RLNote {

        // TODO: complete this logic
        if (!RLJson.contains(oriNote, ['id', 'name', 'html'])) {

            console.log('hi');
            
            throw new Error('Get your json right in backendJsonToRLNote');
        }

        return new RLNote(oriNote.id, oriNote.name, oriNote.html, 
                          oriNote.excerpt, oriNote.mnodifiedTime);
    },

    getNoteByID(id: string): Promise<RLNote> {

        return new Promise((resolve, rejected) => {

            axios.get(config.noteApi('/' + id)).then((res) => {

                const noteJson = res.data;
                
                resolve(this.backendJsonToRLNote(noteJson));
            }).catch(rejected);
        });
    },
};
