import { Router } from "express";

import { produtosRoutes } from "./produto.routes";

const router = Router();

router.use("/produto", produtosRoutes);

export { router };
