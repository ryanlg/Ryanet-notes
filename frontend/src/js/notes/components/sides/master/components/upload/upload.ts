import Modal from '@notes/components/modal';
import Vue from 'vue';
import axios from 'axios';

import config from '@config';

export default {

    components: {

        Modal,
    },

    methods: {

        // have to relay dismiss cause vue only $emit to the direct parent
        relayDismiss() {

            this.$emit('modal-dismiss');
        },

        onFileChange(event: HTMLInputEvent, index: number) {
            const length = this.noteWrappers.length;

            if (index >= 0 && index < length) {

                // there should only be one file
                const fileArray = event.target.files;
                if (fileArray != null) {

                    const firstFile = fileArray[0];

                    const file = new RNNewFile();
                    file.name = firstFile.name;
                    // Make it look better
                    file.trimExtentionFilename();
                    file.camelToRegularFilename();

                    const reader = new FileReader();

                    // arrow function instead of assigning this
                    reader.onload = () => {

                        file.content = reader.result;

                        // wrap it
                        const noteWrapper = new RNNewFileDomWrapper();
                        noteWrapper.note = file;
                        noteWrapper.uploaded = true;

                        // Or Vue can't detect the change
                        Vue.set(this.noteWrappers, index, noteWrapper);
                    };
                    reader.readAsText(firstFile);
                }
            }
        },

        onSubmit() {

            const headers = {
                headers: { 'content-type': 'application/json; charset=utf-8' },
            };

            const actualNoteList: RNNewFile[] = [];
            const wrapperListLength = this.noteWrappers.length;

            for (let i = 0; i < wrapperListLength; i = i + 1) {

                actualNoteList.push(this.noteWrappers[i].note);
            }

            const data = {
                notes: actualNoteList,
            };

            axios.post(config.backend('/api/v1/note/new'), JSON.stringify(data), headers)
                .then((response) => {

                    this.noteHtml = response.data;
                });
        },

        onAddMoreNoteInput() {

            this.noteWrappers.push(new RNNewFileDomWrapper);
        },

        canAddMoreNoteInput() {

            const length = this.noteWrappers.length;
            const lastFileWrapper: RNNewFileDomWrapper = this.noteWrappers[length - 1];
            return lastFileWrapper.uploaded;
        },
    },

    data() {

        return {

            // the default one for display
            noteWrappers: [new RNNewFileDomWrapper()], 
        };
    },
};

interface HTMLInputEvent extends Event {
    target: HTMLInputElement & EventTarget;
}
class RNNewFile {

    name: string;
    content: string;

    constructor() {

        this.name = 'not inited';
        this.content = 'not inited';
    }

    trimExtentionFilename(): void {

        this.name = this.name.replace(/\..+$/, '');
    }


    camelToRegularFilename(): void {

        this.name = this.name.replace(/([a-z])([A-Z])/g, '$1 $2');
    }
}

class RNNewFileDomWrapper {

    note: RNNewFile;
    uploaded: boolean;

    constructor() {
        this.note = new RNNewFile();
        this.uploaded = false;
    }
}
