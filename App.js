import React, { Component } from 'react';
import { StyleSheet, View } from 'react-native';
import MyListView from './ListView';
export default class App extends Component {
  constructor() {
    super();
  }
  render() {
    return (
      <View
      style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
      <MyListView style={{ flex: 1, width: '100%', height: '100%' }} />
      </View>
    );
  }
}
