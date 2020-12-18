import React, { Component, useEffect, useState } from 'react';
import {ActivityIndicator, FlatList, StyleSheet, View, Text } from 'react-native';

import MyListView from './ListView';

export default App = () => {
  const [isLoading, setLoading] = useState(true);
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch('https://jsonplaceholder.typicode.com/comments')
      .then((response) => response.json())
      .then((json) => setData(json))
      .catch((error) => console.error(error))
      .finally(() => setLoading(false));
  }, []);

  return (
    <View style={{ flex: 1, padding: 24 }}>
      {isLoading ? <ActivityIndicator/> : (
        <MyListView style={{ flex: 1, width: '100%', height: '100%' }}
          data={data}
        />
      )}
    </View>
  );
};

