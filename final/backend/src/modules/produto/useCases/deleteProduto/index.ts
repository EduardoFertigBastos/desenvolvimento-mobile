import { ProdutoRepository } from "../../repositories/ProdutoRepository";
import { DeleteProdutoController } from "./DeleteProdutoController";
import { DeleteProdutoUseCase } from "./DeleteProdutoUseCase";

const produtoRepository = ProdutoRepository.getInstance();
const deleteProdutoUseCase = new DeleteProdutoUseCase(produtoRepository);
const deleteProdutoController = new DeleteProdutoController(
  deleteProdutoUseCase
);

export { deleteProdutoController };
