import DevelopmentConfig from 'config/DevelopmentConfig';
import EnvConstants from 'build/env.constants';
import Config from 'config/Config';

let exportConfig: Config;

if (process.env.NODE_ENV === EnvConstants.dev) {

    exportConfig = DevelopmentConfig;
} else {

    // TODO: new config
    exportConfig = DevelopmentConfig; 
}

export default exportConfig;
