import Config from './Config';

export class BaseConfig implements Config {

    public backendURL: string;

    public backend(append: string):string {

        return this.backendURL + append;
    }

    public noteApiUrl = '/api/v1/note';
    public noteApi(append: string): string {

        return this.backend(this.noteApiUrl + append);
    }

    public devServerPort = 8081;
}

export default new BaseConfig();
