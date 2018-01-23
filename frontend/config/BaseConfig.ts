import Config from './Config';

export class BaseConfig implements Config {

    public backendURL: string;

    public backend(append: string):string {

        return this.backendURL + append;
    }

    public devServerPort = 8081;
}

export default new BaseConfig();
