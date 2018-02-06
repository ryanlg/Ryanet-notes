/* tslint:disable */
// configs are handled by GeneralConfig
// so we can just use the dev server
import app from './dev-server';

app.get('/api/v1/note/list', (req, res) => {
    res.type('json');
    res.send(
        '[{"id":1,"name":"Test One","modified_date":"2018-01-05T14:22:25Z"},{"id":2,"name":"Test Two","modified_date":"2018-01-05T14:22:27Z"},{"id":3,"name":"Test Three","modified_date":"2018-01-20T10:40:26Z"},{"id":4,"name":"Test Four","modified_date":"2018-01-20T10:43:07Z"},{"id":5,"name":"Test Five","modified_date":"2018-01-20T10:43:07Z"}]'
    );
});

app.get('/api/v1/note/1', (req, res) => {
    res.type('json');
    res.send(
        '{"id":1,"name":"Test One","raw":"#### hello1?", "html": "<h2 id=\\"hello1\\">hello1?</h2>"}'
    );
});

app.get('/api/v1/note/2', (req, res) => {
    res.type('json');
    res.send(
        '{"id":2,"name":"Test Two","raw":"#### hello2?", "html": "<h2 id=\\"hello2\\">hello2?</h2>"}'
    );
});

app.get('/api/v1/note/3', (req, res) => {
    res.type('json');
    res.send(
        '{"id":3,"name":"Test Three","raw":"#### hello3?", "html": "<h2 id=\\"hello3\\">hello3?</h2>"}'
    );
});

app.get('/api/v1/note/4', (req, res) => {
    res.type('json');
    res.send(
        '{"id":4,"name":"Test Four","raw":"#### hello4?", "html": "<h2 id=\\"hello4\\">hello4?</h2>"}'
    );
});

app.get('/api/v1/note/5', (req, res) => {
    res.type('json');
    res.send(
        '{"id":5,"name":"Test Five","raw":"#### hello5?", "html": "<h2 id=\\"hello5\\">hello5?</h2>"}'
    );
});