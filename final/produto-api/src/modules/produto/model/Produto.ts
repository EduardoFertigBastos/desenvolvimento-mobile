import { v4 as uuidV4 } from "uuid";

class Produto {
  id?: string;
  nome: string;
  descricao: string;
  preco: number;
  created_at: Date;

  constructor() {
    if (!this.id) {
      this.id = uuidV4();
    }
  }
}

export { Produto };
