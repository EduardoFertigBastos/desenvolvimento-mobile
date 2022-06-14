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
    const [nome, setNome] = useState('');
    const [descricao, setDescricao] = useState('');
    const [preco, setPreco] = useState('');
    const [numero, setNumero] = useState('');
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
            await api.patch(`pais/${id}`, { nome, descricao, preco });
        } else {
            await api.post("pais", { nome, descricao, preco });
        }
        loadPaises()
        setId('')
        setNome('')
        setDescricao('')
        setPreco('')
    }

    const handleDelete = async (id: string) => {
        await api.delete(`pais/${id}`);
        loadPaises();
    }

    const handleEdit = (pais: PaisData) => {
        setId(pais.id)
        setNome(pais.nome)
        setDescricao(pais.descricao)
        setPreco(`${pais.preco}`)
    }

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Bem-vindo, Marcondes</Text>
            <Text style={styles.gretting}>Registro de Paises</Text>

            <View style={styles.areaInput}>

                <TextInput
                    value={nome}
                    placeholder="Nome"
                    style={{
                        backgroundColor: '#f1f1f1',
                        marginTop: 10,
                        padding: 10,
                        color: '#333',
                        fontSize: 16,
                    }} 
                    onChangeText={setNome}    
                />
                <TextInput
                    value={descricao}
                    style={{
                        backgroundColor: '#f1f1f1',
                        marginTop: 10,
                        padding: 10,
                        color: '#333',
                        fontSize: 16,
                    }}
                    placeholder="Descrição"
                    onChangeText={setDescricao}
                />

                <TextInput
                    value={preco}
                    style={{
                        backgroundColor: '#f1f1f1',
                        marginTop: 10,
                        padding: 10,
                        color: '#333',
                        fontSize: 16,
                    }}
                    placeholder="Preço"
                    onChangeText={setPreco}
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
