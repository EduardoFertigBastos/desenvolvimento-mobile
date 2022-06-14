import { v4 as uuidV4 } from "uuid";

class Pais {
  id?: string;
  descricao: string;
  sigla: string;
  created_at: Date;

  constructor() {
    if (!this.id) {
      this.id = uuidV4();
    }
  }
}

export { Pais };
