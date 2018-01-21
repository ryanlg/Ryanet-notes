let path = require('path');
let DefinePlugin = require('webpack').DefinePlugin;
let webpackMerge = require('webpack-merge');
let BundleAnalyzerPlugin = require('webpack-bundle-analyzer');
let WebpackNotifierPlugin = require('webpack-notifier');

require('ts-node').register();
let EnvConstants = require('./env.constants.ts');
let baseWebpackConfig = require('./webpack.base.config');

let testVar = webpackMerge(baseWebpackConfig, {

    plugins: [

        // uncomment for analyzer
        // new BundleAnalyzerPlugin({
        //     analyzerMode: 'static'
        // }),

        new WebpackNotifierPlugin(),

        new DefinePlugin({
            'process.env':{
                NODE_ENV: EnvConstants.dev
            }
        })
    ]
});

module.exports = testVar;