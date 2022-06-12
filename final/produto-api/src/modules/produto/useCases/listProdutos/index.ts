import { ProdutoRepository } from "../../repositories/ProdutoRepository";
import { ListProdutosController } from "./ListProdutosController";
import { ListProdutosUseCase } from "./ListProdutosUseCase";

const produtoRepository = ProdutoRepository.getInstance();
const listProdutosUseCase = new ListProdutosUseCase(produtoRepository);
const listProdutosController = new ListProdutosController(listProdutosUseCase);

export { listProdutosController };
