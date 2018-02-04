import index from '.';

export default [
    {
        path: '/',
        component: {
            
        },
    },

    {
        path: '/notes',
        component: index,
    },

    {
        path: '/notes/:id',
        component: index,
    },
];
