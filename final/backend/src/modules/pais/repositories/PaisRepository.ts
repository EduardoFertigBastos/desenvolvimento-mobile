import { Pais } from "../model/Pais";

interface ICreatePaisDTO {
  descricao: string;
  sigla: string;
}

interface IUpdatePaisDTO {
  descricao: string;
  sigla: string;
}

class PaisRepository {
  private paises: Pais[];

  private static INSTANCE: PaisRepository;

  private constructor() {
    this.paises = [];
  }

  public static getInstance(): PaisRepository {
    if (!PaisRepository.INSTANCE) {
      PaisRepository.INSTANCE = new PaisRepository();
    }
    return PaisRepository.INSTANCE;
  }

  list() {
    return this.paises;
  }

  create({ descricao, sigla }: ICreatePaisDTO) {
    const pais = new Pais();

    Object.assign(pais, { descricao, sigla });

    this.paises.push(pais);
  }

  update(id: string, { descricao, sigla }: IUpdatePaisDTO) {
    const pais = this.findById(id);

    if (pais) {
      const indice = this.paises.findIndex((p) => p.id === id);

      const paisUpdated: Pais = {
        ...pais,
        descricao, 
        sigla
      };

      this.paises[indice] = paisUpdated;
    }
  }

  delete(id: string) {
    const newList = this.paises.filter((p) => p.id !== id);

    this.paises = newList;
  }

  findById(id: string): Pais | undefined {
    const user = this.paises.find((u) => u.id === id);

    return user;
  }
}

export { PaisRepository };
