import React, { ReactElement, useState, useEffect } from 'react';
import { 
    View, 
    Text, 
    StyleSheet, 
    TextInput, 
    FlatList,
    Image
} from 'react-native';

import Button from '../../components/Button';
import PaisCard from '../../components/PaisCard';
import { PaisData } from '../../types/pais';
import api from '../../services/api';

export default function Home(): ReactElement {
    const [id, setId] = useState('');
    const [descricao, setDescricao] = useState('');
    const [sigla, setSigla] = useState('');
    const [paises, setPaises] = useState<PaisData[]>([]);

    const loadPaises = async () => {
        const response = await api.get("pais");
        setPaises(response.data)
    }
    
    useEffect(() => {
        loadPaises()
    }, [loadPaises])

    const handleSave = async () => {
        if(id) {
            await api.patch(`pais/${id}`, { descricao, sigla });
        } else {
            await api.post("pais", { descricao, sigla });
        }

        loadPaises();
        setId('');
        setDescricao('');
        setSigla('');
    }

    const handleDelete = async (id: string) => {
        await api.delete(`pais/${id}`);
        loadPaises();
    }

    const handleEdit = (pais: PaisData) => {
        setId(pais.id);
        setDescricao(pais.descricao);
        setSigla(pais.sigla);
    }

    return (
        <View style={styles.container}>
            <Text style={styles.title}>When we were young, the future was so bright</Text>
            <Text style={styles.title}>woooooooah</Text>
            <Text style={styles.title}>the old neighborhood was so alive</Text>
            <Text style={styles.title}>woaaaaah ...</Text>
            <Text style={styles.gretting}>Registro de Paises</Text>

            <View style={styles.areaInput}>

                
                <TextInput
                    value={descricao}
                    style={{
                        backgroundColor: '#f1f1f1',
                        marginTop: 10,
                        padding: 10,
                        color: '#333',
                        fontSize: 16,
                    }}
                    placeholder="Descri????o"
                    onChangeText={setDescricao}
                />

                <TextInput
                    value={sigla}
                    placeholder="Sigla"
                    style={{
                        backgroundColor: '#f1f1f1',
                        marginTop: 10,
                        padding: 10,
                        color: '#333',
                        fontSize: 16,
                    }} 
                    onChangeText={setSigla}    
                />
                
                <Button onPress={handleSave} title="Save" />
                
            </View>
            <Text style={[styles.title, { marginVertical: 10 }]}>Paises Cadastrados</Text>

            {
            paises && (
                <FlatList 
                    data={paises}
                    keyboardShouldPersistTaps="never"
                    keyExtractor={(item) => item.id}
                    showsVerticalScrollIndicator={false}
                    renderItem={({item}) => (
                        <PaisCard 
                            item={item} 
                            onDelete={handleDelete} 
                            onEdit={handleEdit} 
                        />
                    )}
                />
            )
            }


        </View>
    );
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
      paddingVertical: 60,
      paddingHorizontal: 14,
      backgroundColor: '#e0e0e0'
    },
    title: {
      color: '#212121',
      fontSize: 18,
      fontWeight: 'bold'
    },
    gretting:{
      color: '#424242',
    },
    areaInput: {
      width: '100%',
      flexDirection: 'column',
    }
  });
