import React, { useState } from 'react';
import { 
  Text, 
  StyleSheet,
  TouchableOpacity,
  View
} from 'react-native';
import { Feather } from '@expo/vector-icons'; 
import { PaisData } from '../types/pais';

interface PaisCardProps {
  item: PaisData;
  onDelete: (id: string) => Promise<void>
  onEdit: (pais: PaisData) => void
}

export default function PaisCard({ item, onDelete, onEdit }: PaisCardProps) {
  return (
    <View style={styles.list}>
      <Text style={styles.namePais}>
        {item.nome}
      </Text>

      <View style={styles.actionsArea}>
        <TouchableOpacity style={{ marginRight: 15 }} onPress={() => onEdit(item)}>
          <Feather name="edit" size={18} color="white" />
        </TouchableOpacity>
        <TouchableOpacity onPress={() => onDelete(item.id)}>
          <Feather name="trash" size={18} color="white" />
        </TouchableOpacity>
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  list: {
    backgroundColor: '#0288d1',
    padding: 10,
    borderRadius: 8,
    marginTop: 8,
    flexDirection: 'row',
    justifyContent: 'space-between'
  },
  namePais: {
    color: '#fff',
    fontSize: 18,
  },
  actionsArea: {
    flexDirection: 'row',
  }
});