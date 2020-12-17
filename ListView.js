import PropTypes from 'prop-types';

import { requireNativeComponent, ViewPropTypes } from 'react-native';
var viewProps = {
  name: 'MyListView',
  propTypes: {
    url: PropTypes.string,
   ...ViewPropTypes,
  }
}
module.exports = requireNativeComponent('MyListView', viewProps);
