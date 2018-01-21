import { resolve } from 'url';
import Config from './Config';

export class BaseConfig implements Config {

    public backendURL: string

    public backend(append: string):string {

        return this.backendURL + append;
    }
}

export default new BaseConfig();