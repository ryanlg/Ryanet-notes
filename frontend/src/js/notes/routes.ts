import index from '.';
import { master, viewer } from '@notes/components/sides';

export default [

    {
        path: '/notes',
        component: index,
        children: [{
            path: '/',
            components: {
                master,
                viewer,
            },
            props: {
                master: false,
                viewer: true,
            },
        }],
    },

    {
        path: '/notes/:id',
        component: index,
        children: [{
            path: '/',
            components: {
                master,
                viewer,
            },
            props: {
                master: false,
                viewer: true,
            },
        }],
    },
];
