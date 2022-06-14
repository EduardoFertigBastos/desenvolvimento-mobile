import React from 'react';
import { 
  Text, 
  StyleSheet,
  TouchableOpacity,
  TouchableOpacityProps
} from 'react-native';

type ButtonProps = TouchableOpacityProps &  {
  title: string;
};

export default function Button({ title, ...rest }: ButtonProps) {
  return (
    <TouchableOpacity 
      style={styles.button} 
      activeOpacity={0.7}
      {...rest}
    >
      <Text style={styles.buttonText}>{title}</Text>
    </TouchableOpacity>
  )
}

const styles = StyleSheet.create({
  button: {
    marginTop: 20,
    //marginLeft: 10,
    backgroundColor: '#01579b',
    padding: 10,
    borderRadius: 7,
    alignItems: 'center'
  },
  buttonText: {
    color: '#fff',
    fontSize: 14,
    fontWeight: 'bold'
  },
});