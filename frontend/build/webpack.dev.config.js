let path = require('path');
let webpack = require('webpack')
let webpackMerge = require('webpack-merge');
let BundleAnalyzerPlugin = require('webpack-bundle-analyzer');
let WebpackNotifierPlugin = require('webpack-notifier');
let FriendlyErrorPlugin = require('friendly-errors-webpack-plugin');

require('ts-node').register();
let EnvConstants = require('./env.constants.ts');
let baseWebpackConfig = require('./webpack.base.config');

module.exports = webpackMerge(baseWebpackConfig, {

    plugins: [

        // uncomment for analyzer
        // new BundleAnalyzerPlugin({
        //     analyzerMode: 'static'
        // }),

        new WebpackNotifierPlugin(),

        new webpack.DefinePlugin({
            'process.env':{
                NODE_ENV: EnvConstants.dev
            }
        }),

        // HRM
        new webpack.HotModuleReplacementPlugin(),
        new webpack.NoEmitOnErrorsPlugin(),

        new FriendlyErrorPlugin()
    ]
});