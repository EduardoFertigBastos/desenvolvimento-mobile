import { Produto } from "../../model/Produto";
import { ProdutoRepository } from "../../repositories/ProdutoRepository";

class ListProdutosUseCase {
  constructor(private produtosRepository: ProdutoRepository) {}
  execute(): Produto[] {
    const produtos = this.produtosRepository.list();

    return produtos;
  }
}

export { ListProdutosUseCase };
