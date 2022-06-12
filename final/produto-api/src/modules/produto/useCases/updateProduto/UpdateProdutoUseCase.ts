import { ProdutoRepository } from "../../repositories/ProdutoRepository";

interface IRequest {
  nome: string;
  descricao: string;
  preco: number;
}

class UpdateProdutoUseCase {
  constructor(private produtosRepository: ProdutoRepository) {}

  execute(id: string, { nome, descricao, preco }: IRequest) {
    this.produtosRepository.update(id, { nome, descricao, preco });
  }
}

export { UpdateProdutoUseCase };
