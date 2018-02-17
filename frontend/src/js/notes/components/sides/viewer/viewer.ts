import Vue from 'vue';
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
                    this.doMathjax();
                });
            }
        },
    },

    methods: {

        doMathjax() {

            // DOM update happens on the next tick.
            // For Mathjax to work equations has to be in the DOM already.
            Vue.nextTick(() => {
                MathJax.Hub.Queue([
                    'Typeset',
                    MathJax.Hub,
                    'markdown',
                ]);
            });
        },
    },
};
